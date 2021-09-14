package Services;
import Exceptions.OverdrawnException;
import Models.Acct;
import Repositories.Daoacct;


public class Acctservices {

    Daoacct da = new Daoacct();

    public void withdrawal(Acct a, Integer amt){

        int prevBal = a.getBal();
        int newBal = prevBal - amt;

        try {
            checkOverdrawn(newBal);
            a.setBal(newBal);
            da.updateAcct(a);

        } catch (OverdrawnException e){
            //e.printStackTrace();
            System.out.println("Please enter in an amount less than your balance.");
        }
    }

    public void checkOverdrawn(Integer newBal) throws OverdrawnException {

        if(newBal < 0){

            throw new OverdrawnException("Sorry but you cannot withdraw more than your current balance.");
        }
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
