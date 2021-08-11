package manageDetails;

public class OutputData {
    int sNo =0;
    public void printSortedAccList(Integer count,AccountInfo accountInfo){

        sNo =  count + sNo;
        System.out.print("\n"+sNo+".AccNo: "+accountInfo.getAccNo()+", AccBalance: "+accountInfo.getAccBalance()+", BankBranch: "+accountInfo.getAccBranch());
    }
    public void printAllAccList(AccountInfo accountInfo){
        System.out.println("\nAccId: "+accountInfo.getAccId()+", AccNo: "+accountInfo.getAccNo()+", AccBalance: "+accountInfo.getAccBalance()+", BankBranch: "+accountInfo.getAccBranch());

    }

}
