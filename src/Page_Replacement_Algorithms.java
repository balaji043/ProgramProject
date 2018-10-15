import java.util.Scanner;

public class Page_Replacement_Algorithms {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] pages = Array.getArray();
        int memory_Size = scanner.nextInt();
        System.out.println();
        System.out.println(LRU_Algorithm(pages, memory_Size));
    }

    private static int LRU_Algorithm(int[] pages, int memory_size) {
        int page_Fault = 0, goes = 0, j = 0, max, k, flag, index;
        int[] memory = new int[memory_size];
        int[] tag = new int[memory_size];

        System.out.println("Comes\tGoes\tInside\tPageFault\t\tj\tTag");
        for (int page : pages) {
            // taking single page from pages
            flag = 0;
            // if the page is in memory
            for (k = 0; k < memory_size; k++) {
                if (memory[k] == page) {
                    //if the page is in memory find index of that page
                    // tag of index as 1
                    //increment everything else
                    for (int m = 0; m < memory_size; m++)
                        tag[m]++;
                    tag[k] = 1;
                    flag = 1;
                    break;
                }
            }
            //if page not in memory
            if (flag == 0) {
                page_Fault++;
                //if memory is not full
                if (j < memory_size) {
                    memory[j] = page;
                    for (k = 0; k <= j; k++) tag[k]++;
                    j++;
                }
                //if memory is full
                if (j > memory_size) {
                    //replace the page with max tag
                    max = tag[0];
                    index = 0;
                    //find the index of max tag
                    for (k = 0; k < memory_size; k++) {
                        if (tag[k] > max) {
                            max = tag[k];
                            index = k;
                        }
                    }
                    //increment everything in tag except in index temp
                    for (k = 0; k < memory_size; k++) {
                        if (k != index) tag[k]++;
                    }
                    //store the memory of temp in goes
                    //page in memory of temp
                    //tag[temp] as 1
                    //increment page fault
                    goes = memory[index];
                    memory[index] = page;
                    tag[index] = 1;
                }
                if (j == memory_size) {
                    j = memory_size + 1;
                }
            }

            if (flag == 1) System.out.printf("%5d\t----\t", page);
            else System.out.printf("%5d\t%4d\t", page, goes);
            for (k = 2; k >= 0; k--) {
                System.out.printf("%2d", memory[k]);
            }
            System.out.printf("\t%8d\t%4d\t", page_Fault, j);
            for (k = 0; k < memory_size; k++) {
                System.out.printf("%d", tag[k]);
            }
            System.out.println();
        }
        return page_Fault;
    }

}
/*

12
1 2 4 3 2 5 4 2 1 4 2 5

 */
/*
Comes	Goes	Inside	PageFault      j
    1	   0	 0 0 1	       1	   1
    2	   0	 0 2 1	       2	   2
    4	   0	 4 2 1	       3	   4
    3	   1	 4 2 3	       4	   4
    2	----	 4 2 3	       4	   4
    5	   4	 5 2 3	       5	   4
    4	   3	 5 2 4	       6	   4
    2	----	 5 2 4	       6	   4
    1	   5	 1 2 4	       7	   4
    4	----	 1 2 4	       7	   4
    2	----	 1 2 4	       7	   4
    5	   1	 5 2 4	       8	   4

 */

/* private static int LRU(int[] pages,int memory_Size){
        int flag,temp=0,j=0,max,goes = 0;
        int[] memory = new int[memory_Size];
        int[] tag = new int[memory_Size];
        int page_Fault =0;
        System.out.println("Comes\tGoes\tInside\tPageFault\t\tj\tTag");
        for (int page : pages) {
            // taking single page from pages
            flag = 0;
            //check if the page is in memory
            for (int k = 0; k < memory_Size; k++) {
                if (page == memory[k]) {
                    flag = 1;
                    tag[k]=1;
                    temp=k;
                    break;
                }
            }
            //if the page is in memory index of that page in memory is temp and tag it as 1;
            if(flag==1){
                for(int k=0;k<memory_Size;k++){
                 if(temp!=k){
                     tag[k]++;
                 }
                }
            }
            //else if page not in memory
            else{
                //if j<memory_size
                //store the page in memory index j
                //increment k
                //increment tag of everything upto j
                if(j<memory_Size){
                    memory[j]=page;
                    page_Fault++;
                    for(int k=0;k<=j;k++)
                        tag[k]++;
                    j++;
                }
                //if j>memory_size
                //find the max tag and index of the max is in temp
                if (j>memory_Size){
                    temp=0;
                    max=tag[0];
                    for (int k=0;k<memory_Size;k++){
                        if(tag[k]>=max){
                            temp=k;
                            max=tag[temp];
                        }
                    }
                    for(int k=0;k<memory_Size;k++){
                        if(temp!=k)tag[k]++;
                    }
                    //store the memory of temp in goes
                    //page in memory of temp
                    //tag[temp] as 1
                    //increment page fault
                    goes=memory[temp];
                    memory[temp]=page;
                    tag[temp]=1;
                    page_Fault++;
                }
                //j is memory size j=4
                if(j==memory_Size)j=4;
            }
            if(flag==1) System.out.printf("%5d\t----\t",page);
            else System.out.printf("%5d\t%4d\t",page,goes);
            for(int k=2;k>=0;k--){
                System.out.printf("%2d",memory[k]);
            }
            System.out.printf("\t%8d\t%4d\t",page_Fault,j);
            for(int k=0;k<memory_Size;k++){
                System.out.printf("%d",tag[k]);
            }
            System.out.println();
        }
        return page_Fault;
    }*/