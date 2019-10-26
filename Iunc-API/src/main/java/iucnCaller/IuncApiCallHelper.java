package iucnCaller;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import sun.net.www.protocol.http.HttpURLConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;


/**
 * help class to access IUNC API.
 *
 * @author Puyan Chubak
 *
 * @param <R>
 *            the result object from Call
 */
public class IuncApiCallHelper<R> {

    private static final String IUNC_URL= "http://apiv3.iucnredlist.org/api/v3/";
    private static final String ACCESS_TOKEN= "?token=9bb4facb6d23f48efbf424bb05c0c1ef1cf6f468393bc745d42179ac4aca5fee";

    private final Class<R> resultType;

    public IuncApiCallHelper(Class<R> resultTypeClass) {
        this.resultType = resultTypeClass;
    }


    /**
     *  IUNC special request
     *
     * @param addToUrl
     *            die Url
     * @return response-Objekt
     * @throws ResourceServerException if the response has Statuscode = 400, then is a
     *                                  problem with authentication
     *
     * @throws ProblemWithHttpsException if there is a problem  Https-connection
     * @throws IOException if no access to Resource
     */
    protected R makeHttpRequest(String addToUrl) throws ResourceServerException, ProblemWithHttpsException, IOException {

        R responseObj = null;

        try {
            SSLContextBuilder builder = new SSLContextBuilder();
            builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(builder.build());

            CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();

            HttpGet req = new HttpGet(IUNC_URL + addToUrl + ACCESS_TOKEN);

            HttpResponse response = httpClient.execute(req);

            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode >= 400) {
                httpClient.close();
                throw new ResourceServerException(statusCode, response.getStatusLine().getReasonPhrase());
            }
            if (response.getStatusLine().getStatusCode() == 200) {
                responseObj = convertResponseToObject(response);
                httpClient.close();
            }

        } catch (KeyStoreException | NoSuchAlgorithmException | KeyManagementException e) {
            throw new ProblemWithHttpsException(e.getClass() + " " + e.getMessage());
        }

        return responseObj;
    }

    /**
     * Interpret the HTTP-Response from IUNC and create a JSON-Object
     *
     * @param response
     *            HTTP response
     * @return das Responseobject
     * @throws ResourceServerException
     *             if there is a problem with authentication or other problems
     *
     */
    private R convertResponseToObject(HttpResponse response) throws ResourceServerException {

        String content = null;
        try {
            content = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (IOException e) {
            throw new ResourceServerException();
        }

        if (content != null) {

            com.google.gson.Gson gson = new com.google.gson.Gson();
            R resultObject = gson.fromJson(content, resultType);

            return resultObject;

        } else {
            throw new ResourceServerException();
        }
    }

}
