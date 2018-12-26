import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    //==================================================Version 1 Start===============================
    public String statement() {

        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            // double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();

            //  thisAmount = each.getCharge();
            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDayRented() > 1) {
                frequentRenterPoints++;
            }
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
            totalAmount += each.getCharge();
        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned" + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }
}
//
//   private double amountFor(Rental aRental) {
//       return aRental.getCharge();
//
//   }
//=================================================Version 1 End===============================
//
// //=====================================Version 0  start======================================
//   public String statement() {
//
//       double totalAmount = 0;
//       int frequentRenterPoints = 0;
//       Enumeration rentals = _rentals.elements();
//       String result = "Rental Record for " + getName() + "\n";
//       while (rentals.hasMoreElements()) {
//           double thisAmount = 0;
//           Rental each = (Rental) rentals.nextElement();
//
//           // determine amounts for each line
//           switch (each.getMovie().getPriceCode()) {
//               case Movie.REGULAR:
//                   thisAmount += 2;
//                   if (each.getDayRented() > 2) {
//                       thisAmount += (each.getDayRented() - 2) * 1.5;
//                   }
//                   break;
//               case Movie.NEW_RELEASE:
//                   thisAmount += each.getDayRented() * 3;
//                   break;
//               case Movie.CHILDRENS:
//                   thisAmount += 1.5;
//                   if (each.getDayRented() > 3) {
//                       thisAmount += (each.getDayRented() - 3) * 1.5;
//                   }
//                   break;
//           }
//           // add frequent renter points
//           frequentRenterPoints++;
//           // add bonus for two day new release rental
//           if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDayRented() > 1) {
//               frequentRenterPoints++;
//           }
//           // show figures for this rental
//           result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
//           thisAmount += thisAmount;
//       }
//       // add footer lines
//       result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
//       result += "You earned" + String.valueOf(frequentRenterPoints) + " frequent renter points";
//       return result;
//   }
 //=====================================Version 0  end======================================