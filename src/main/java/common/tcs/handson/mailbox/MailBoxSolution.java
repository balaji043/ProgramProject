package common.tcs.handson.mailbox;

public class MailBoxSolution {

    public static void main(String[] args) {
        sort();
        replace();
        search();
        getMailBoxByPosition();
    }

    private static void getMailBoxByPosition() {
        MailBox mailbox1 = new MailBox(73, "kdqktps", "glwiegn");
        MailBox mailbox2 = new MailBox(77, "qjftnil", "fbigazj");
        MailBox mailbox3 = new MailBox(95, "ukeadms", "egndouz");
        MailBox mailbox4 = new MailBox(87, "njhzbtc", "orcmqza");
        MailBox mailbox5 = new MailBox(29, "dyifepd", "avfznpr");


        MailBox[] objArray = {mailbox1, mailbox2, mailbox3, mailbox4, mailbox5};
        print("MailBox Array Original", objArray);

        MailBox[] even = getMailBoxByOddOrEvenPosition(objArray, true);
        print("Even Position Mail Box", even);
        MailBox[] odd = getMailBoxByOddOrEvenPosition(objArray, false);
        print("Odd Position Mail Box", odd);
    }

    private static MailBox[] getMailBoxByOddOrEvenPosition(MailBox[] objArray, boolean isEven) {
        MailBox[] mailBoxes;
        int n = objArray.length, arrSize, j = 0;
        // 1 2 3 4 5 6
        // 0 1 2 3 4 5  Even(6) ->     e - 3 ; o - 3
        // 0 1 2        Odd(3) ->      e - 2 ; o - 1

        if (isEven)
            //if         //true  //false
            arrSize = (n % 2 == 0) ? n / 2 : (n / 2) + 1;
        else
            arrSize = (n % 2 == 0) ? n / 2 : (n / 2);

        mailBoxes = new MailBox[arrSize];

        for (int i = 0; i < n; i++) {
            //Even
            if (isEven && i % 2 == 0)
                mailBoxes[j++] = objArray[i];
            // Odd
            if (!isEven && i % 2 != 0)
                mailBoxes[j++] = objArray[i];

        }

        return mailBoxes;
    }

    //                     Search
    private static void search() {

        MailBox mailbox1 = new MailBox(73, "kdqktps", "glwiegn");
        MailBox mailbox2 = new MailBox(77, "qjftnil", "fbigazj");
        MailBox mailbox3 = new MailBox(95, "ukeadms", "egndouz");
        MailBox mailbox4 = new MailBox(87, "njhzbtc", "orcmqza");
        MailBox mailbox5 = new MailBox(29, "dyifepd", "avfznpr");


        MailBox[] objArray = {mailbox1, mailbox2, mailbox3, mailbox4, mailbox5};
        print("MailBox Array Original", objArray);

        MailBox[] objResultArray1 = searchMailBoxByName(objArray, "njhzbtc");
        if (objResultArray1 == null)
            System.out.println("Output after SearchMailBoxByName is null. ");
        else
            print("Displaying contents of SearchMailBoxByName array: ", objResultArray1);

        MailBox[] objResultArray2 = searchMailBoxByCreationDate(objArray, "orcmqza");
        if (objResultArray2 == null)
            System.out.println("Output after SearchMailBoxByCreationDate is null. ");
        else
            print("Displaying contents of SearchMailBoxByCreationDate array: "
                    , objResultArray2);

    }

    private static MailBox[] searchMailBoxByName(MailBox[] objArray, String name) {
        int i = 0;
        for (MailBox m : objArray)
            if (m.getName().equals(name)) i++;
        if (i == 0)
            return null;
        else {
            MailBox[] newMailBox = new MailBox[i];
            i = 0;
            for (MailBox m : objArray)
                if (m.getName().equals(name))
                    newMailBox[i++] = m;
            return newMailBox;
        }
    }

    private static MailBox[] searchMailBoxByCreationDate(MailBox[] objArray
            , String creationDate) {
        int i = 0;
        for (MailBox m : objArray)
            if (m.getCreationDate().equals(creationDate)) i++;
        if (i == 0)
            return null;
        else {
            MailBox[] newMailBox = new MailBox[i];
            i = 0;
            for (MailBox m : objArray)
                if (m.getCreationDate().equals(creationDate))
                    newMailBox[i++] = m;
            return newMailBox;
        }
    }

    ///                      sorting
    private static void sort() {
        MailBox mailbox1 = new MailBox(73, "kdqktps", "glwiegn");
        MailBox mailbox2 = new MailBox(77, "qjftnil", "fbigazj");
        MailBox mailbox3 = new MailBox(95, "ukeadms", "egndouz");
        MailBox mailbox4 = new MailBox(87, "njhzbtc", "orcmqza");
        MailBox mailbox5 = new MailBox(29, "dyifepd", "avfznpr");


        MailBox[] objArray = {mailbox1, mailbox2, mailbox3, mailbox4, mailbox5};
        print("MailBox Array Original", objArray);

        MailBox[] objArraySortedById = sortMailBoxById(objArray);
        print("MailBox Array Sorted by id", objArraySortedById);

        MailBox[] objArraySortedByName = sortMailBoxByName(objArray);
        print("MailBox Array Sorted by Name", objArraySortedByName);

        MailBox[] objArraySortedByCreationDate = sortMailBoxByCreationDate(objArray);
        print("MailBox Array Sorted by Creation Date", objArraySortedByCreationDate);

    }

    private static MailBox[] sortMailBoxById(MailBox[] objArray) {
        int n = objArray.length;
        MailBox temp;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (objArray[i].getId() > objArray[j].getId()) {
                    //swap
                    temp = objArray[i];
                    objArray[i] = objArray[j];
                    objArray[j] = temp;
                }
        return objArray;
    }

    private static MailBox[] sortMailBoxByName(MailBox[] objArray) {
        int n = objArray.length;
        MailBox temp;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (objArray[i].getName().compareTo(objArray[j].getName()) > 0) {
                    //swap
                    temp = objArray[i];
                    objArray[i] = objArray[j];
                    objArray[j] = temp;
                }
        return objArray;
    }

    private static MailBox[] sortMailBoxByCreationDate(MailBox[] objArray) {
        int n = objArray.length;
        MailBox temp;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (objArray[i].getCreationDate().compareTo(objArray[j].getCreationDate()) > 0) {
                    //swap
                    temp = objArray[i];
                    objArray[i] = objArray[j];
                    objArray[j] = temp;
                }
        return objArray;
    }

    //                        Replace
    private static void replace() {
        MailBox mailbox1 = new MailBox(22, "rsqhpiz", "yjsympz");
        MailBox mailbox2 = new MailBox(83, "xwjrqnu", "ahrxtbb");
        MailBox mailbox3 = new MailBox(47, "zgesjsr", "cxnkctl");
        MailBox mailbox4 = new MailBox(66, "xaosles", "jvdrtxf");
        MailBox mailbox5 = new MailBox(1, "yilxuua", "ycnejof");

        MailBox[] objArray = {mailbox1, mailbox2, mailbox3, mailbox4, mailbox5};
        MailBox mailboxRes1 = new MailBox(27, "ffatwgo", "dkxgaid");

        boolean result = replaceMailBoxById(objArray, mailboxRes1);
        String message = "Output for performing replace on mailboxRes1 is : " + result + "\n"
                + "Displaying contents of array: ";
        print(message, objArray);

        MailBox mailboxRes2 = new MailBox(1, "hqzmrfz", "fcbudyi");
        result = replaceMailBoxById(objArray, mailboxRes2);

        message = "Output for performing replace on mailboxRes2 is : " + result + "\n"
                + "Displaying contents of array: ";
        print(message, objArray);

    }

    private static boolean replaceMailBoxById(MailBox[] objArray, MailBox mailbox) {
        for (int i = 0; i < objArray.length; i++)
            if (mailbox.getId() == objArray[i].getId()) {
                objArray[i] = mailbox;
                return true;
            }
        return false;
    }

    //                         print Array
    private static void print(String message, Object[] array) {
        System.out.println(message + "\n");
        for (Object o : array) System.out.println(o.toString());
        System.out.println();
    }


}
