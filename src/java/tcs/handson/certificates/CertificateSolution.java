package java.tcs.handson.certificates;

public class CertificateSolution {
    public static void main(String[] args) {

        Certificate certificate1 = new Certificate(60, "cnexirk", "cbnifms", 77);
        Certificate certificate2 = new Certificate(45, "gphspvq", "pqjbhmz", 62);
        Certificate certificate3 = new Certificate(41, "nfpxsmp", "vimiopu", 89);
        Certificate certificate4 = new Certificate(95, "ionouca", "bsbknpx", 38);
        Certificate certificate5 = new Certificate(39, "yhzrafu", "itnbskb", 44);

        Certificate[] objArray = {certificate1, certificate2, certificate3
                , certificate4, certificate5};

        Certificate[] evenPositionCertificate = getEvenPositionCertificate(objArray);

        System.out.println("Displaying contents of getEvenPositionCertificate: ");

        for (Certificate certificate : evenPositionCertificate)
            System.out.println(certificate.toString());

        Certificate[] searchCertificateByRank = searchCertificateByRank(objArray, 77);

        Certificate[] searchCertificateByRank1 = searchCertificateByRank(objArray, 60);

        System.out.println("Displaying contents of searchCertificateByRank: ");

        for (Certificate certificate : searchCertificateByRank)
            System.out.println(certificate.toString());

        for (Certificate certificate : searchCertificateByRank1)
            System.out.println(certificate.toString());

    }

    private static Certificate[] searchCertificateByRank(Certificate[] objArray, int i) {
        int k = 0;
        for (Certificate certificate : objArray)
            if (certificate.getRank() == i)
                k++;
        Certificate[] evenPosition = new Certificate[k];
        k = 0;
        for (Certificate certificate : objArray)
            if (certificate.getRank() == i)
                evenPosition[k++] = certificate;

        return evenPosition;
    }

    private static Certificate[] getEvenPositionCertificate(Certificate[] objArray) {
        Certificate[] evenPosition = new Certificate[objArray.length / 2 + 1];
        int j = 0;
        for (int i = 0; i < objArray.length; i++)
            if (i % 2 == 0)
                evenPosition[j++] = objArray[i];

        return evenPosition;
    }
}
