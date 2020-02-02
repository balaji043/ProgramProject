package common.tcs;

public class Producer {
    public boolean isServicingAgent;
    public String lifeLicense;
    public String medicalLicense;

    public Producer(boolean isServicingAgent, String lifeLicense, String medicalLicense) {
        this.isServicingAgent = isServicingAgent;
        this.lifeLicense = lifeLicense;
        this.medicalLicense = medicalLicense;
    }
}
