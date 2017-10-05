import static org.junit.Assert.*;
import org.junit.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;


public class RentACatTest {
	
	//Re-usable RentACat reference
	RentACat _rac;
	//Create a new cat before each test
	@Before
	public void setup(){
		_rac = new RentACat();
	}
	
	//Assert that creating a new Cat does not return a null reference
	@Test
	public void testCatExists(){
		assertNotNull(_rac);
	}
	
	//Returning a cat that has not been rented should return false 
	@Test
	public void returnCatNotRented(){
		Cat mockCat = mock(Cat.class);
		when(mockCat.getRented()).thenReturn(false);
		assertFalse(_rac.returnCat(mockCat));
	}
	
	//Returning a cat that has been rented should return true
	@Test
	public void returnCatRented(){
		Cat mockCat = mock(Cat.class);
		when(mockCat.getRented()).thenReturn(true);
		assertTrue(_rac.returnCat(mockCat));
	}
	
	//Renting a cat that has not been rented out should return true
	@Test
	public void rentCatNotRented(){
		Cat mockCat = mock(Cat.class);
		when(mockCat.getRented()).thenReturn(false);
		assertTrue(_rac.rentCat(mockCat));
	}
	
	//Renting a cat that has been rented out should return false
	@Test
	public void rentCatRented(){
		Cat mockCat = mock(Cat.class);
		when(mockCat.getRented()).thenReturn(true);
		assertFalse(_rac.rentCat(mockCat));
	}
	
	//Only unrented cats should be listed
	@Test
	public void listCatsAllUnrented(){
		ArrayList<Cat> listOfCats = new ArrayList<Cat>();
		Cat mockCat1 = mock(Cat.class);
		Cat mockCat2 = mock(Cat.class);
		listOfCats.add(mockCat1);
		listOfCats.add(mockCat2);
		when(mockCat1.getRented()).thenReturn(false);
		when(mockCat1.toString()).thenReturn("Snuffles");
		when(mockCat2.getRented()).thenReturn(false);
		when(mockCat2.toString()).thenReturn("Pumpkin");
		assertEquals(_rac.listCats(listOfCats), "Snuffles\nPumpkin\n");
	}
	
	//Only unrented cats should be listed
	@Test
	public void listCatsOneRented(){
		ArrayList<Cat> listOfCats = new ArrayList<Cat>();
		Cat mockCat1 = mock(Cat.class);
		Cat mockCat2 = mock(Cat.class);
		listOfCats.add(mockCat1);
		listOfCats.add(mockCat2);
		when(mockCat1.getRented()).thenReturn(false);
		when(mockCat1.toString()).thenReturn("Snuffles");
		when(mockCat2.getRented()).thenReturn(true);
		when(mockCat2.toString()).thenReturn("Pumpkin");
		assertEquals(_rac.listCats(listOfCats), "Snuffles\n");
	}
	
	//If an empty list of cats is passed in, should return false
	@Test
	public void catExistsEmptyList(){
		ArrayList<Cat> listOfCats = new ArrayList<Cat>();
		assertFalse(_rac.catExists(1, listOfCats));
	}
	
	//If the list contains the id, return true
	@Test
	public void catExistsInList(){
		ArrayList<Cat> listOfCats = new ArrayList<Cat>();
		Cat mockCat = mock(Cat.class);
		listOfCats.add(mockCat);
		when(mockCat.getId()).thenReturn(2);
		assertTrue(_rac.catExists(2, listOfCats));
	}
	
	//If the list does not contain the id, return false
	@Test
	public void catExistsNotInList(){
		ArrayList<Cat> listOfCats = new ArrayList<Cat>();
		Cat mockCat = mock(Cat.class);
		listOfCats.add(mockCat);
		when(mockCat.getId()).thenReturn(3);
		assertFalse(_rac.catExists(2, listOfCats));
	}
	
	
	
	
	
	
	
}
