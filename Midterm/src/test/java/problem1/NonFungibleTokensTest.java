package problem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NonFungibleTokensTest {
    private DigitalArt testDigitalArt;
    private Game testGame;
    private Music testMusic;
    private Name name1;
    private Name name2;
    private ArrayList<Name> names;


    @BeforeEach
    void setUp() throws InvalidPriceException, InvalidNumOfDaysListedException {
        names = new ArrayList<>();
        name1 = new Name("Jin", "Young", "Park", "JYP");
        name2 = new Name("Michael", "Suzanne", "Jackson", "MJ");
        names.add(name1);
        names.add(name2);
        testDigitalArt = new DigitalArt("thememe", names, names, 8, 350.0, "ERC-721");
        testGame = new Game("goodGame", names, names, 80, 8000.0, "ERC-721");
        testMusic = new Music("goodMusic", names, names, 5, 3500.0, "Bitcoin");

        // exception case where the numOfDaysListed is below zero
        Exception InvalidNumOfDaysListedException = assertThrows(Exception.class,
                () -> testDigitalArt = new DigitalArt("thememe", names, names, -1, 350.0, "ERC-721"));
        assertEquals("Invalid Days!", InvalidNumOfDaysListedException.getMessage());

        // exception case where the latestAskingPrice is below zero
        Exception InvalidPriceException = assertThrows(Exception.class,
                () -> testDigitalArt = new DigitalArt("thememe", names, names, 8, -350.0, "ERC-721"));
        assertEquals("Invalid Price!", InvalidPriceException.getMessage());
    }

    @Test
    void getName() {
        assertEquals("thememe", testDigitalArt.getName());
        assertEquals("goodGame", testGame.getName());
        assertEquals("goodMusic", testMusic.getName());
    }

    @Test
    void setName() {
        testDigitalArt.setName("goodMeme");
        assertEquals("goodMeme", testDigitalArt.getName());
    }

    @Test
    void getCreator() {
        ArrayList<Name> expected = new ArrayList<>();
        expected.add(name1);
        expected.add(name2);
        assertEquals(expected, testDigitalArt.getCreator());
    }

    @Test
    void setCreator() {
        ArrayList<Name> expected = new ArrayList<>();
        Name newName = new Name("Stranger", "P", "Person", "SPP");
        expected.add(newName);
        testDigitalArt.setCreator(expected);
        assertEquals(expected, testDigitalArt.getCreator());
    }

    @Test
    void getOwner() {
        ArrayList<Name> expected = new ArrayList<>();
        expected.add(name1);
        expected.add(name2);
        assertEquals(expected, testDigitalArt.getOwner());
    }

    @Test
    void setOwner() {
        ArrayList<Name> expected = new ArrayList<>();
        Name newName = new Name("Real", "P", "Owner", "TheReal");
        expected.add(newName);
        testDigitalArt.setOwner(expected);
        assertEquals(expected, testDigitalArt.getOwner());
    }

    @Test
    void getNumOfDaysListed() {
        assertEquals(8, testDigitalArt.getNumOfDaysListed());
        assertEquals(80, testGame.getNumOfDaysListed());
        assertEquals(5, testMusic.getNumOfDaysListed());
    }

    @Test
    void setNumOfDaysListed() throws InvalidNumOfDaysListedException {
        testDigitalArt.setNumOfDaysListed(150);
        assertEquals(150, testDigitalArt.getNumOfDaysListed());
        // exception case where the numOfDaysListed is below zero
        Exception InvalidNumOfDaysListedException = assertThrows(Exception.class,
                () -> testDigitalArt.setNumOfDaysListed(-1));
        assertEquals("Invalid Days!", InvalidNumOfDaysListedException.getMessage());
    }

    @Test
    void getLatestAskingPrice() {
        assertEquals(350.0, testDigitalArt.getLatestAskingPrice());
        assertEquals(8000.0, testGame.getLatestAskingPrice());
        assertEquals(3500.0, testMusic.getLatestAskingPrice());
    }

    @Test
    void setLatestAskingPrice() throws InvalidPriceException {
        testDigitalArt.setLatestAskingPrice(150000.0);
        assertEquals(150000.0, testDigitalArt.getLatestAskingPrice());
        // exception case where the latestAskingPrice is below zero
        Exception InvalidPriceException = assertThrows(Exception.class,
                () -> testDigitalArt.setLatestAskingPrice(-2000.0));
        assertEquals("Invalid Price!", InvalidPriceException.getMessage());
    }

    @Test
    void getTokenStandard() {
        assertEquals("ERC-721", testDigitalArt.getTokenStandard());
        assertEquals("ERC-721", testGame.getTokenStandard());
        assertEquals("Bitcoin", testMusic.getTokenStandard());
    }

    @Test
    void setTokenStandard() {
        testDigitalArt.setTokenStandard("Bitcoin-1530");
        assertEquals("Bitcoin-1530", testDigitalArt.getTokenStandard());
    }

    @Test
    void calculateBaseValue() {
        Double expectedPrice = 350.0 * 1.25;
        assertEquals(expectedPrice, testDigitalArt.calculateBaseValue());
    }

    @Test
    void applyOldEthereumPriceChange() {
        // testDigitalArt has ERC-721 as its token, but it only has been on auction for 8 days, so it is not applied.
        // the price for testDigitalArt will remain as base value
        Double memeExpected = 350.0 * 1.25;
        assertEquals(memeExpected, testDigitalArt.applyOldEthereumPriceChange());
        // testGame has ERC-721 as its token, and it has been on auction for 80 days, so it is applied.
        // the price for testGame will be 6000.
        Double gameExpected = 8000 * 1.25 * 0.6;
        assertEquals(gameExpected, testGame.applyOldEthereumPriceChange());
    }

    @Test
    void calculateStartingBid() throws InvalidNumOfDaysListedException {
        // testDigitalArt does not apply to price change for ERC-721, and since it had been only 8 days, so it is not applied to
        // the 0.7 decrease due to 15 days on the auction.
        Double memeExpected = 350.0 * 1.25;
        assertEquals(memeExpected, testDigitalArt.calculateStartingBid());
        // when its numOfDaysListed to 30, then the price decrease will be applied.
        testDigitalArt.setNumOfDaysListed(30);
        Double newMemeExpected = memeExpected * 0.7;
        assertEquals(newMemeExpected, testDigitalArt.calculateStartingBid());

        Double musicExpected = 3500.0 * 1.25;
        assertEquals(musicExpected, testMusic.calculateStartingBid());
    }

    @Test
    void testEquals_SameObject() {
        assertTrue(testDigitalArt.equals(testDigitalArt));
        assertTrue(testGame.equals(testGame));
        assertTrue(testMusic.equals(testMusic));
    }

    @Test
    void testEquals_DifferentObject() throws InvalidPriceException, InvalidNumOfDaysListedException {
        ArrayList<Name> newNames = new ArrayList<>();
        Name newName = new Name("Real", "P", "Owner", "TheReal");
        newNames.add(newName);
        ArrayList<Double> widthHeight = new ArrayList<>();
        widthHeight.add(35.0);
        widthHeight.add(80.0);
        Lifestyle lifeStylePic = new Lifestyle("life", newNames, newNames, 3, 150000.0, widthHeight, "Canon", "old");
        assertFalse(testDigitalArt.equals(lifeStylePic));
        assertFalse(testGame.equals(lifeStylePic));
        assertFalse(testMusic.equals(lifeStylePic));
    }

    @Test
    void testEquals_NullObject() {
        assertFalse(testDigitalArt.equals(null));
        assertFalse(testGame.equals(null));
        assertFalse(testMusic.equals(null));
    }

    @Test
    void testEquals_DifferentName() throws InvalidPriceException, InvalidNumOfDaysListedException {
        DigitalArt newArt = new DigitalArt("noArt", names, names, 8, 350.0, "ERC-721");
        Game newGame = new Game("noGame", names, names, 80, 8000.0, "ERC-721");
        Music newMusic = new Music("noMusic", names, names, 5, 3500.0, "Bitcoin");
        assertFalse(testDigitalArt.equals(newArt));
        assertFalse(testGame.equals(newGame));
        assertFalse(testMusic.equals(newMusic));
    }

    @Test
    void testEquals_DifferentCreator() throws InvalidPriceException, InvalidNumOfDaysListedException {
        ArrayList<Name> newList = new ArrayList<>();
        Name newName = new Name("Real", "P", "Owner", "TheReal");
        newList.add(newName);
        DigitalArt newArt = new DigitalArt("thememe", newList, names, 8, 350.0, "ERC-721");
        Game newGame = new Game("goodGame", newList, names, 80, 8000.0, "ERC-721");
        Music newMusic = new Music("goodMusic", newList, names, 5, 3500.0, "Bitcoin");
        assertFalse(testDigitalArt.equals(newArt));
        assertFalse(testGame.equals(newGame));
        assertFalse(testMusic.equals(newMusic));
    }

    @Test
    void testEquals_DifferentOwner() throws InvalidPriceException, InvalidNumOfDaysListedException {
        ArrayList<Name> newList = new ArrayList<>();
        Name newName = new Name("Real", "P", "Owner", "TheReal");
        newList.add(newName);
        DigitalArt newArt = new DigitalArt("thememe", names, newList, 8, 350.0, "ERC-721");
        Game newGame = new Game("goodGame", names, newList, 80, 8000.0, "ERC-721");
        Music newMusic = new Music("goodMusic", names, newList, 5, 3500.0, "Bitcoin");
        assertFalse(testDigitalArt.equals(newArt));
        assertFalse(testGame.equals(newGame));
        assertFalse(testMusic.equals(newMusic));
    }

    @Test
    void testEquals_DifferentNumOfDaysListed() throws InvalidPriceException, InvalidNumOfDaysListedException {
        DigitalArt newArt = new DigitalArt("thememe", names, names, 150, 350.0, "ERC-721");
        Game newGame = new Game("goodGame", names, names, 3, 8000.0, "ERC-721");
        Music newMusic = new Music("goodMusic", names, names, 1, 3500.0, "Bitcoin");
        assertFalse(testDigitalArt.equals(newArt));
        assertFalse(testGame.equals(newGame));
        assertFalse(testMusic.equals(newMusic));
    }

    @Test
    void testEquals_DifferentLatestAskingPrice() throws InvalidPriceException, InvalidNumOfDaysListedException {
        DigitalArt newArt = new DigitalArt("thememe", names, names, 8, 8000.0, "ERC-721");
        Game newGame = new Game("goodGame", names, names, 80, 800000.0, "ERC-721");
        Music newMusic = new Music("goodMusic", names, names, 5, 250.0, "Bitcoin");
        assertFalse(testDigitalArt.equals(newArt));
        assertFalse(testGame.equals(newGame));
        assertFalse(testMusic.equals(newMusic));
    }

    @Test
    void testEquals_DifferentTokenStandard() throws InvalidPriceException, InvalidNumOfDaysListedException {
        DigitalArt newArt = new DigitalArt("thememe", names, names, 8, 350.0, "BTC-200");
        Game newGame = new Game("goodGame", names, names, 80, 8000.0, "ERC-800");
        Music newMusic = new Music("goodMusic", names, names, 5, 3500.0, "BTC-001");
        assertFalse(testDigitalArt.equals(newArt));
        assertFalse(testGame.equals(newGame));
        assertFalse(testMusic.equals(newMusic));
    }

    @Test
    void testEquals_DifferentObjectsSameAttribute() throws InvalidPriceException, InvalidNumOfDaysListedException {
        DigitalArt newArt = new DigitalArt("thememe", names, names, 8, 350.0, "ERC-721");
        Game newGame = new Game("goodGame", names, names, 80, 8000.0, "ERC-721");
        Music newMusic = new Music("goodMusic", names, names, 5, 3500.0, "Bitcoin");
        assertTrue(testDigitalArt.equals(newArt));
        assertTrue(testGame.equals(newGame));
        assertTrue(testMusic.equals(newMusic));
    }

    @Test
    void testHashCode() throws InvalidPriceException, InvalidNumOfDaysListedException {
        ArrayList<Name> newNames = new ArrayList<>();
        Name newName1 = new Name("Jin", "Young", "Park", "JYP");
        Name newName2 = new Name("Michael", "Suzanne", "Jackson", "MJ");
        newNames.add(newName1);
        newNames.add(newName2);
        DigitalArt newArt = new DigitalArt("thememe", newNames, newNames, 8, 350.0, "ERC-721");
        Game newGame = new Game("goodGame", newNames, newNames, 80, 8000.0, "ERC-721");
        Music newMusic = new Music("goodMusic", newNames, newNames, 5, 3500.0, "Bitcoin");
        assertTrue(testDigitalArt.hashCode() == newArt.hashCode());
        assertTrue(testGame.hashCode() == newGame.hashCode());
        assertTrue(testMusic.hashCode() == newMusic.hashCode());
    }

    @Test
    void testToString() {
        String expected = "NonFungibleTokens{" +
                "name='" + "goodGame" + '\'' +
                ", creator=" + "[Name{firstName='Jin', middleName='Young', lastName='Park', nickName='JYP'}, Name{firstName='Michael', middleName='Suzanne', lastName='Jackson', nickName='MJ'}]" +
                ", owner=" + "[Name{firstName='Jin', middleName='Young', lastName='Park', nickName='JYP'}, Name{firstName='Michael', middleName='Suzanne', lastName='Jackson', nickName='MJ'}]" +
                ", numOfDaysListed=" + "80" +
                ", latestAskingPrice=" + "8000.0" +
                ", tokenStandard='" + "ERC-721" + '\'' +
                '}';
        assertEquals(expected, testGame.toString());
    }
}
