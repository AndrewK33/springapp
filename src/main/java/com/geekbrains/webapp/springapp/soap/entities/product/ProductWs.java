
package com.geekbrains.webapp.springapp.soap.entities.product;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for product complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="product">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="categoryTitle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "product", namespace = "http://www.geekbrains.com/webapp/springapp/ws/products", propOrder = {
    "id",
    "title",
    "price",
    "categoryTitle"
})
public class ProductWs {

    @XmlElement(namespace = "http://www.geekbrains.com/webapp/springapp/ws/products")
    protected long id;
    @XmlElement(namespace = "http://www.geekbrains.com/webapp/springapp/ws/products", required = true)
    protected String title;
    @XmlElement(namespace = "http://www.geekbrains.com/webapp/springapp/ws/products")
    protected int price;
    @XmlElement(namespace = "http://www.geekbrains.com/webapp/springapp/ws/products", required = true)
    protected String categoryTitle;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(int value) {
        this.price = value;
    }

    /**
     * Gets the value of the categoryTitle property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCategoryTitle() {
        return categoryTitle;
    }

    /**
     * Sets the value of the categoryTitle property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCategoryTitle(String value) {
        this.categoryTitle = value;
    }

}
