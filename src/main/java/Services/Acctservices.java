package Services;
import Models.Acct;
import Repositories.Daoacct;


public class Acctservices {

    Daoacct da = new Daoacct();
    Acct a = new Acct();

    public void withdrawal(Acct a, Integer amt){
        int prevBal = a.getBal();
        int newBal = prevBal - amt;
        a.setBal(newBal);
        da.updateAcct(a);
    }

    public void deposit(Acct a, Integer amt){
        int prevBal = a.getBal();
        int newBal = prevBal + amt;
        a.setBal(newBal);
        da.updateAcct(a);
    }

    public boolean acctExist(String ssn){

        if(da.getAcctBySsn(ssn) != null) {

            return true;
        }
        return false;
    }

    public boolean idMatch(String ssn, Integer id){
        Acct acct = da.getAcctBySsn(ssn);
        if(id == acct.getAcctId()){
            return true;
        }
        return false;
    }
}
