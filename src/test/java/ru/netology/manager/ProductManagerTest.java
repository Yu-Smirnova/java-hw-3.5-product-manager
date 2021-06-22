package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    private Book book1 = new Book(1, "Book1", 10, "Auth1");
    private Book book2 = new Book(2, "Book2", 20, "Auth1");
    private Smartphone smartphone1 = new Smartphone(3, "Smartphone1", 10, "Manufacturer1");
    private Smartphone smartphone2 = new Smartphone(4, "Smartphone2", 20, "Manufacturer2");
    private Product other = new Product(5, "Other", 100);

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(other);
    }


    @Test
    public void shouldSearchByBookAuthorWhenExist() {

        Product[] result = manager.searchBy("Auth1");

        Product[] expected = {book1, book2};
        Product[] actual = result;

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByBookNameWhenExist() {

        Product[] result = manager.searchBy("Book1");

        Product[] expected = {book1};
        Product[] actual = result;

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmartphoneNameWhenExist() {

        Product[] result = manager.searchBy("Smartphone2");

        Product[] expected = {smartphone2};
        Product[] actual = result;

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmartphoneManufacturerWhenExist() {

        Product[] result = manager.searchBy("Manufacturer1");

        Product[] expected = {smartphone1};
        Product[] actual = result;

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmartphoneNameWhenNotExist() {

        Product[] result = manager.searchBy("Smartphone3");

        Product[] expected = new Product[0];
        Product[] actual = result;

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByBookNameWhenNotExist() {

        Product[] result = manager.searchBy("Book3");

        Product[] expected = new Product[0];
        Product[] actual = result;

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByProductName() {

        Product[] result = manager.searchBy("Other");

        Product[] expected = {other};
        Product[] actual = result;

        assertArrayEquals(expected, actual);
    }

}
