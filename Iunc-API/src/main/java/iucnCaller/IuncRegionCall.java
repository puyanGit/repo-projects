package iucnCaller;

import iucnResp.CmResponseRegion;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public class IuncRegionCall extends IuncApiCallHelper<CmResponseRegion> {


    private static final String ADD_TO_URL= "region/list";

    public IuncRegionCall(Class<CmResponseRegion> resultTypeClass){
        super(resultTypeClass);
    }


    public CmResponseRegion executeCall()
            throws ResourceServerException, IOException, ProblemWithHttpsException{

        return makeHttpRequest(ADD_TO_URL);


    }


}
