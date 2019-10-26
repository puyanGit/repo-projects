package iucnResp;

public class CmResponseRegion {

    private Integer count;
    private CmResponseRegionResult[] results;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public CmResponseRegionResult[] getResults() {
        return results;
    }

    public void setResults(CmResponseRegionResult[] results) {
        this.results = results;
    }
}
