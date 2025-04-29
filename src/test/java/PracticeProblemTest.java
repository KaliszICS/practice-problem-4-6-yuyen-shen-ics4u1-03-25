import java.lang.reflect.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class PracticeProblemTest {

    @Test
    public void testPersonClassExists() {
        try {
            Class.forName("Person");
            assertTrue(true);
        } catch (ClassNotFoundException e) {
            fail("Person class does not exist");
        }
    }
    
    @Test
    public void testPersonConstructor() {
        try {
            Class<?> personClass = Class.forName("Person");
            Constructor<?> constructor = personClass.getConstructor(
                String.class, String.class, int.class, int.class, int.class, String.class);
            assertNotNull(constructor, 
                    "Constructor with (String, String, int, int, int, String) parameters should exist");
        } catch (ClassNotFoundException e) {
            fail("Person class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Person constructor with (String, String, int, int, int, String) parameters does not exist");
        }
    }
    
    @Test
    public void testGettersAndSetters() {
        try {
            Class<?> personClass = Class.forName("Person");
            
            // Test getFirstname method
            Method getFirstnameMethod = personClass.getMethod("getFirstname");
            assertEquals(String.class, getFirstnameMethod.getReturnType(), 
                    "getFirstname() should return String");
            
            // Test setFirstname method
            Method setFirstnameMethod = personClass.getMethod("setFirstname", String.class);
            assertEquals(void.class, setFirstnameMethod.getReturnType(), 
                    "setFirstname() should return void");
            
            // Test getLastname method
            Method getLastnameMethod = personClass.getMethod("getLastname");
            assertEquals(String.class, getLastnameMethod.getReturnType(), 
                    "getLastname() should return String");
            
            // Test setLastname method
            Method setLastnameMethod = personClass.getMethod("setLastname", String.class);
            assertEquals(void.class, setLastnameMethod.getReturnType(), 
                    "setLastname() should return void");
            
            // Test getBirthday method
            Method getBirthdayMethod = personClass.getMethod("getBirthday");
            assertEquals(String.class, getBirthdayMethod.getReturnType(), 
                    "getBirthday() should return String");
        } catch (ClassNotFoundException e) {
            fail("Person class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Required method does not exist: " + e.getMessage());
        }
    }
    
    @Test
    public void testAddSiblingMethod() {
        try {
            Class<?> personClass = Class.forName("Person");
            Method addSiblingMethod = personClass.getMethod("addSibling", personClass);
            assertEquals(void.class, addSiblingMethod.getReturnType(), 
                    "addSibling(Person) should return void");
        } catch (ClassNotFoundException e) {
            fail("Person class does not exist");
        } catch (NoSuchMethodException e) {
            fail("addSibling(Person) method does not exist");
        }
    }
    
    @Test
    public void testGetterSetterFunctionality() {
        try {
            Class<?> personClass = Class.forName("Person");
            Constructor<?> constructor = personClass.getConstructor(
                String.class, String.class, int.class, int.class, int.class, String.class);
            
            // Create a person
            Object person = constructor.newInstance("John", "Doe", 1, 1, 2000, "123-45-6789");
            
            // Test firstname getter and setter
            Method getFirstnameMethod = personClass.getMethod("getFirstname");
            Method setFirstnameMethod = personClass.getMethod("setFirstname", String.class);
            
            String initialFirstname = (String) getFirstnameMethod.invoke(person);
            assertEquals("John", initialFirstname, "getFirstname() should return the initial firstname value");
            
            setFirstnameMethod.invoke(person, "Jane");
            String newFirstname = (String) getFirstnameMethod.invoke(person);
            assertEquals("Jane", newFirstname, "getFirstname() should return the new firstname value after setFirstname()");
            
            // Test lastname getter and setter
            Method getLastnameMethod = personClass.getMethod("getLastname");
            Method setLastnameMethod = personClass.getMethod("setLastname", String.class);
            
            String initialLastname = (String) getLastnameMethod.invoke(person);
            assertEquals("Doe", initialLastname, "getLastname() should return the initial lastname value");
            
            setLastnameMethod.invoke(person, "Smith");
            String newLastname = (String) getLastnameMethod.invoke(person);
            assertEquals("Smith", newLastname, "getLastname() should return the new lastname value after setLastname()");
        } catch (ClassNotFoundException e) {
            fail("Person class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Required method does not exist: " + e.getMessage());
        } catch (Exception e) {
            fail("Error testing getter/setter functionality: " + e.getMessage());
        }
    }
    
    @Test
    public void testGetBirthdayFormat() {
        try {
            Class<?> personClass = Class.forName("Person");
            Constructor<?> constructor = personClass.getConstructor(
                String.class, String.class, int.class, int.class, int.class, String.class);
            
            // Create a person with specific birthday
            Object person = constructor.newInstance("John", "Doe", 22, 3, 2000, "123-45-6789");
            
            // Test getBirthday method
            Method getBirthdayMethod = personClass.getMethod("getBirthday");
            String birthday = (String) getBirthdayMethod.invoke(person);
            
            assertEquals("22/3/2000", birthday, 
                    "getBirthday() should return birthDay/birthMonth/birthYear in that format");
        } catch (ClassNotFoundException e) {
            fail("Person class does not exist");
        } catch (NoSuchMethodException e) {
            fail("getBirthday() method does not exist");
        } catch (Exception e) {
            fail("Error testing getBirthday format: " + e.getMessage());
        }
    }
    
    @Test
    public void testAddSiblingFunctionality() {
        try {
            Class<?> personClass = Class.forName("Person");
            Constructor<?> constructor = personClass.getConstructor(
                String.class, String.class, int.class, int.class, int.class, String.class);
            
            // Create a main person
            Object person1 = constructor.newInstance("John", "Doe", 1, 1, 2000, "123-45-6789");
            
            // Create siblings
            Object person2 = constructor.newInstance("Jane", "Doe", 2, 2, 2002, "234-56-7890");
            Object person3 = constructor.newInstance("Jim", "Doe", 3, 3, 2003, "345-67-8901");
            
            // Add siblings
            Method addSiblingMethod = personClass.getMethod("addSibling", personClass);
            Method getSiblingsMethod = personClass.getMethod("getSiblings");
            
            // Add first sibling and check
            addSiblingMethod.invoke(person1, person2);
            Object siblingsAfterOne = getSiblingsMethod.invoke(person1);
            
            assertNotNull(siblingsAfterOne, "getSiblings() should not return null");
            assertEquals(1, Array.getLength(siblingsAfterOne), 
                    "After adding one sibling, getSiblings() should return an array of length 1");
            
            // Add second sibling and check
            addSiblingMethod.invoke(person1, person3);
            Object siblingsAfterTwo = getSiblingsMethod.invoke(person1);
            
            assertNotNull(siblingsAfterTwo, "getSiblings() should not return null");
            assertEquals(2, Array.getLength(siblingsAfterTwo), 
                    "After adding two siblings, getSiblings() should return an array of length 2");
            
            // Check that the siblings array contains the correct siblings
            Method getFirstnameMethod = personClass.getMethod("getFirstname");
            
            Object firstSibling = Array.get(siblingsAfterTwo, 0);
            Object secondSibling = Array.get(siblingsAfterTwo, 1);
            
            String firstSiblingName = (String) getFirstnameMethod.invoke(firstSibling);
            String secondSiblingName = (String) getFirstnameMethod.invoke(secondSibling);
            
            assertEquals("Jane", firstSiblingName, "First sibling should be Jane");
            assertEquals("Jim", secondSiblingName, "Second sibling should be Jim");
        } catch (ClassNotFoundException e) {
            fail("Person class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Required method does not exist: " + e.getMessage());
        } catch (Exception e) {
            fail("Error testing addSibling functionality: " + e.getMessage());
        }
    }
    
    @Test
    public void testFieldsArePrivate() {
        try {
            Class<?> personClass = Class.forName("Person");
            Field[] fields = personClass.getDeclaredFields();
            
            // Verify that all declared fields in the Person class are private
            for (Field field : fields) {
                assertTrue(Modifier.isPrivate(field.getModifiers()), 
                        "Field '" + field.getName() + "' should be private");
            }
            
            // Verify at least some expected fields exist (without depending on specific names)
            assertTrue(fields.length >= 8, 
                    "Person class should have at least 8 fields (firstname, lastname, birthDay, " +
                    "birthMonth, birthYear, ssn, numberOfSiblings, siblings)");
            
            // Check types of fields without accessing them
            boolean hasStringFields = false, hasIntFields = false, hasArrayField = false;
            
            for (Field field : fields) {
                if (field.getType() == String.class) {
                    hasStringFields = true;
                } else if (field.getType() == int.class) {
                    hasIntFields = true;
                } else if (field.getType().isArray()) {
                    Class<?> componentType = field.getType().getComponentType();
                    if (componentType.getName().equals("Person")) {
                        hasArrayField = true;
                    }
                }
            }
            
            assertTrue(hasStringFields, "Person class should have String fields");
            assertTrue(hasIntFields, "Person class should have int fields");
            assertTrue(hasArrayField, "Person class should have a Person[] field");
            
        } catch (ClassNotFoundException e) {
            fail("Person class does not exist");
        }
    }
    
    @Test
    public void testEmptySiblingsDefaultValue() {
        try {
            Class<?> personClass = Class.forName("Person");
            Constructor<?> constructor = personClass.getConstructor(
                String.class, String.class, int.class, int.class, int.class, String.class);
            
            // Create a person
            Object person = constructor.newInstance("John", "Doe", 1, 1, 2000, "123-45-6789");
            
            // Get siblings without using field access
            Method getSiblingsMethod = personClass.getMethod("getSiblings");
            Object siblings = getSiblingsMethod.invoke(person);
            
            assertNotNull(siblings, "Default siblings array should not be null");
            assertEquals(0, Array.getLength(siblings), 
                    "Default siblings array should be empty (length 0)");
        } catch (ClassNotFoundException e) {
            fail("Person class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Required method does not exist: " + e.getMessage());
        } catch (Exception e) {
            fail("Error testing default siblings value: " + e.getMessage());
        }
    }
}
