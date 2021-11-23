package com.carlosfrmax.example.cucumber.integrationTests;

import com.carlosfrmax.example.domain.Product;
import com.carlosfrmax.example.services.ProductsService;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.is;

public class ExampleStepDefinitions {

    @Autowired
    @Qualifier("ProductsServiceImp")
    ProductsService productService;

    List<Product> products;
    Product productOne;

    @Before
    public void beforeTests(){
        removeAllProducts();
    }

    private void removeAllProducts() {
        products = productService.getAllProducts();
        for (Product product: new ArrayList<>(products)) {
            productService.delete(product);
        }
    }

    @Given("no products")
    public void no_products() {
        assertThat(productService.getAllProducts().size(), is(0));
    }

    @When("the user ask for the list of products")
    public void the_user_ask_for_the_list_of_products() {
        products = productService.getAllProducts();
    }
    @Then("the user receives an empty list of products")
    public void the_user_receives_an_empty_list_of_products() {
        products = productService.getAllProducts();
        assertThat(products.size(),is(0));
    }

    @Then("the user receives a list with one Product")
    public void the_user_receives_a_list_with_one_product() {
        products = productService.getAllProducts();
        assertThat(products.size(),is(1));
    }

    @When("the user add one product named {string} and priced {int}")
    public void theUserAddOneProductNamedAndPriced(String name, int price) {
        Product product = new Product(name, price);
        productService.save(product);
    }

    @Then("the user receives a list with one Product named {string} and priced {int}")
    public void theUserReceivesAListWithOneProductNamedAndPriced(String name, int price) {
        products = productService.getAllProducts();
        assertThat(products.size(),is(1));
        assertThat(products.get(0).getName(),is(name));
        assertThat(products.get(0).getPrice(),is(price));
    }

    @When("the user add products:")
    public void theUserAddProducts(DataTable dataTable) {
        addProducts(dataTable);
    }

    @Then("the user receives a list with three Products:")
    public void theUserReceivesAListWithThreeProducts(DataTable dataTable) {
        products = productService.getAllProducts();
        assertThatListsOfProductsAreEquals(dataTable, products, 3);
    }

    private void assertThatListsOfProductsAreEquals(DataTable dataTable, List<Product> products, int size) {
        assertThat(products.size(),is(size));
        List<Map<String,String>> productsTestTable =  dataTable.asMaps(String.class, String.class);
        for (Map<String, String> columns : productsTestTable){
            Product product = this.products.stream().filter(p -> p.getName().equals(columns.get("name"))).collect(Collectors.toList()).get(0);
            assertThat(product.getPrice(),is(Integer.parseInt(columns.get("price"))));
        }
    }

    @Given("a list of products:")
    public void aListOfProducts(DataTable dataTable) {
        addProducts(dataTable);
    }

    @When("the user add two products:")
    public void theUserAddTwoProducts(DataTable dataTable) {
        addProducts(dataTable);
    }

    private void addProducts(DataTable dataTable) {
        List<Map<String, String>> products = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> columns : products) {
            productService.save(new Product(columns.get("name"), Integer.parseInt(columns.get("price"))));
        }
    }

    @Then("the user receives a list with one Product:")
    public void theUserReceivesAListWithOneProduct(DataTable dataTable) {
        products = productService.getAllProducts();
        assertThatListsOfProductsAreEquals(dataTable, products, 1);
    }

    @When("the user delete one product")
    public void theUserDeleteOneProduct() {
        productService.delete(productService.getAllProducts().get(0));
    }

    @When("the user delete all the products")
    public void theUserDeleteAllTheProducts() {
        removeAllProducts();
    }

    @When("the user delete products:")
    public void theUserDeleteProducts(DataTable dataTable) {
        removeProducts(dataTable);
    }

    private void removeProducts(DataTable dataTable) {
        List<Map<String, String>> products = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> columns : products) {
            productService.delete(new Product(columns.get("name"), Integer.parseInt(columns.get("price"))));
        }
    }

    @When("the user delete two products")
    public void theUserDeleteTwoProducts() {
        List<Product> products = productService.getAllProducts();
        productService.delete(products.get(0));
        productService.delete(products.get(1));
    }
}
