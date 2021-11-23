Feature: Products Service functionalities

  Scenario: Retrieve an empty list of products
    Given no products
    When the user ask for the list of products
    Then the user receives an empty list of products

  Scenario: Add one product
    Given no products
    When the user add one product named "raspberry pi" and priced 35
    Then the user receives a list with one Product named "raspberry pi" and priced 35

  Scenario: Add 3 product
    Given no products
    When the user add products:
      |name        |price|
      |raspberry pi|35   |
      |arduino 1   |10   |
      |arduino mega|20   |
    Then the user receives a list with three Products:
      |name        |price|
      |raspberry pi|35   |
      |arduino 1   |10   |
      |arduino mega|20   |

  Scenario: Add two products
    Given a list of products:
      |name        |price|
      |arduino mega|20   |
    When the user add products:
      |name        |price|
      |raspberry pi|35   |
      |arduino 1   |10   |
    Then the user receives a list with three Products:
      |name        |price|
      |arduino mega|20   |
      |raspberry pi|35   |
      |arduino 1   |10   |

  Scenario: Retrieve one product
    Given a list of products:
      |name        |price|
      |arduino mega|20   |
    When the user ask for the list of products
    Then the user receives a list with one Product:
      |name        |price|
      |arduino mega|20   |

  Scenario: Retrieve 3 products
    Given a list of products:
      |name        |price|
      |arduino mega|20   |
      |raspberry pi|35   |
      |arduino 1   |10   |
    When the user ask for the list of products
    Then the user receives a list with three Products:
      |name        |price|
      |arduino mega|20   |
      |raspberry pi|35   |
      |arduino 1   |10   |

  Scenario: Delete one Product
    Given a list of products:
      |name        |price|
      |arduino mega|20   |
    When the user delete one product
    Then the user receives an empty list of products

  Scenario: Delete all Products
    Given a list of products:
      |name        |price|
      |arduino mega|20   |
      |raspberry pi|35   |
      |arduino 1   |10   |
    When the user delete all the products
    Then the user receives an empty list of products

  Scenario: Delete 2 Products
    Given a list of products:
      |name        |price|
      |arduino mega|20   |
      |raspberry pi|35   |
      |arduino 1   |10   |
    When the user delete two products
    Then the user receives a list with one Product

#  Scenario: Delete 2 Product
#    Given a list of products:
#      |name        |price|
#      |arduino mega|20   |
#      |raspberry pi|35   |
#      |arduino 1   |10   |
#    When the user delete products:
#      |name        |price|
#      |arduino mega|20   |
#      |raspberry pi|35   |
#    Then the user receives a list with one Product:
#      |name        |price|
#      |arduino 1   |10   |






