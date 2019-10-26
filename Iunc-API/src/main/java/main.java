import iucnResp.CmResponseRegion;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;


public class main {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        CmResponseRegion cmResponseRegion = new CmResponseRegion();

        cmResponseRegion = new iucnCaller.IuncRegionCall(iucnResp.CmResponseRegion.class).executeCall();
    }

}
