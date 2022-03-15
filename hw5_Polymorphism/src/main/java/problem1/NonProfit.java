package problem1;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class NonProfit {

  /**
   * CS5004 Spring2022 Jin Young Park hw5 NonProfit.java
   * <p>
   * NonProfit represents a nonprofit organization and tracks all donations made. When a donation is
   * made, it is stored in the hashmap, collection. If the donation is a monthly donation, it is
   * also stored in a list, continuingMonthlyDonation. With the information, it calculates the total
   * donation amount in a certain year.
   * <p>
   * When the Pledge donation's processing date is getting modified, the user should make sure to
   * remove the original Pledge donation first before setting the processingDate of the Pledge
   * donation. After setting the processingDate, the user should receive the Pledge donation back so
   * that the collection has modified information of the Pledge donation.
   */
  protected String OrganizationName;
  protected HashMap<Integer, ArrayList<Donation>> collection;
  protected ArrayList<MonthlyDonation> monthlyDonations;
  private final int totalMonthsInYear = 12;

  /**
   * Constructor of NonProfit
   *
   * @param organizationName - the name of the organization, as String
   * @param collection       - the collection of donations made, as HashMap
   * @param monthlyDonations - the collection of monthly donations made, as ArrayList
   */
  public NonProfit(String organizationName,
      HashMap<Integer, ArrayList<Donation>> collection,
      ArrayList<MonthlyDonation> monthlyDonations) {
    this.OrganizationName = organizationName;
    this.collection = collection;
    this.monthlyDonations = monthlyDonations;
  }

  /**
   * Getter for OrganizationName
   *
   * @return the name of the organization that NonProfit class represents
   */
  public String getOrganizationName() {
    return this.OrganizationName;
  }

  /**
   * Setter for OrganizationName
   *
   * @param organizationName - changes the name of the organization, encoded as String
   */
  public void setOrganizationName(String organizationName) {
    this.OrganizationName = organizationName;
  }

  /**
   * Getter for collection
   *
   * @return the HashMap collection of donations made so far
   */
  public HashMap<Integer, ArrayList<Donation>> getCollection() {
    return this.collection;
  }

  /**
   * Getter for
   *
   * @return the ArrayList collection of monthly donations made so far
   */
  public ArrayList<MonthlyDonation> getMonthlyDonations() {
    return monthlyDonations;
  }

  /**
   * Calculates the total amount of a monthly donation donated in a certain year
   *
   * @param m    - a MonthlyDonation class represents a single monthly donation
   * @param year - a year as int
   * @return the total amount of a monthly donation donated in a given year in float
   */
  public float getThisYearMonthly(MonthlyDonation m, int year) {
    if (m.getCancellationDate() == null) {
      // if null cancel but created this year
      if (m.getDate().getYear() < year) {
        return totalMonthsInYear * m.getAmount();
        // if null cancel created before this year
      } else {
        return (totalMonthsInYear - m.getDate().getMonthValue()) * m.getAmount();
      }
    } else {
      // if cancellation date is later than this year
      if (m.getCancellationDate().getYear() > year) {
        return totalMonthsInYear * m.getAmount();
      } else {
        // checks if the monthly donation should be made on the cancellation month.
        if (m.getCancellationDate().isBefore(
            LocalDateTime.of(year, m.getCancellationDate().getMonthValue(),
                m.getDate().getDayOfMonth(), m.getDate().getHour(), m.getDate().getMinute()))) {
          return m.getAmount() * (m.getCancellationDate().getMonthValue() - 1);
        } else {
          return m.getAmount() * (m.getCancellationDate().getMonthValue());
        }
      }
    }
  }

  /**
   * Get the total amount of all donations made in a certain year
   *
   * @param year - a year as int
   * @return the total amount donated in a specific year. The function makes sure that there is no
   * overlap of monthly donations as they are tracked twice.
   */
  public float getTotalDonationForYear(int year) {
    ArrayList<Donation> donationForYear = this.collection.get(year);
    float sum = 0;
    // add donation amounts from the collection hashMap
      if (donationForYear != null) {
          for (Donation d : donationForYear) {
              if (d != null) {
                  sum += d.getAmount();
              }
          }
      }
    // add monthly donation amounts from the monthlyDonation ArrayList
      if (this.monthlyDonations != null) {
          for (MonthlyDonation m : this.monthlyDonations) {
              if (m.getCancellationDate() == null || m.getCancellationDate().getYear() >= year) {
                  sum += getThisYearMonthly(m, year);
              }
          }
      }

    return sum;
  }

  /**
   * Helper function for receiveDonation Adds a donation class into the collection hashMap with the
   * key as the donation's year
   *
   * @param key   - the year that the donation was made, as Integer
   * @param value - the donation class
   */
  public void addToMap(Integer key, Donation value) {
    if (!this.collection.containsKey(key)) {
      this.collection.put(key, new ArrayList<>());
    }
    this.collection.get(key).add(value);
  }

  /**
   * Using addToMap, adds a donation class into the collection hashMap with the key as the
   * donation's year Overload class (OneTimeDonation)
   *
   * @param d - the donation class
   */
  public void receiveDonation(OneTimeDonation d) {
    int year = d.getDate().getYear();
    this.addToMap(year, d);
  }

  /**
   * Using addToMap, adds a donation class into the collection hashMap with the key as the
   * donation's year Also adds the donation class to monthlyDonation list Overload class
   * (MonthlyDonation)
   *
   * @param d - the donation class
   */
  public void receiveDonation(MonthlyDonation d) {
    int year = d.getDate().getYear();
    this.addToMap(year, d);
    this.monthlyDonations.add(d);
  }

  /**
   * Using addToMap, adds a donation class into the collection hashMap with the key as the
   * donation's year Overload class (Pledges)
   *
   * @param d - the donation class
   */
  public void receiveDonation(Pledges d) {
    if (d.getProcessingDate() != null) {
      int year = d.getProcessingDate().getYear();
      this.addToMap(year, d);
    } else {
      this.addToMap(null, d);
    }
  }

  /**
   * removes a pledge donation when the pledge donation's processing date is getting modified. MUST
   * RUN BEFORE SET THE PROCESSING DATE. MUST RUN receiveDonation after setting the processing
   * date.
   *
   * @param d - a pledge donation which processing date is getting modified.
   */
  public void removeOldPledges(Pledges d) {
    // checks if the key of the pledge donation was null or integer year.
    Integer year;
    if (d.getProcessingDate() == null) {
      year = null;
    } else {
      year = d.getProcessingDate().getYear();
    }
    // make a new arraylist to copy all the other donations in the same list.
    ArrayList<Donation> newDonationList = new ArrayList<>();
    for (int i = 0; i < this.collection.get(year).size(); i++) {
      if (!this.collection.get(year).get(i).equals(d)) {
        newDonationList.add(this.collection.get(year).get(i));
      }
    }
    // if there were other donations than the modified donation, then add the key and new donation list to the collection
    // if there was no donation other than the modified donation, then just remove the whole key.
    this.collection.remove(year);
      if (newDonationList.size() > 0) {
          this.collection.put(year, newDonationList);
      }
  }

  /**
   * equals method for NonProfit class
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NonProfit nonProfit = (NonProfit) o;
    return Objects.equals(OrganizationName, nonProfit.OrganizationName) &&
        Objects.equals(collection, nonProfit.collection) &&
        Objects.equals(monthlyDonations, nonProfit.monthlyDonations);
  }

  /**
   * hashCode method for NonProfit class
   */
  @Override
  public int hashCode() {
    return Objects.hash(OrganizationName, collection, monthlyDonations, totalMonthsInYear);
  }

  /**
   * toString method for NonProfit class
   */
  @Override
  public String toString() {
    return "NonProfit{" +
        "OrganizationName='" + OrganizationName + '\'' +
        ", collection=" + collection +
        ", continuingMonthlyDonation=" + monthlyDonations +
        '}';
  }
}
