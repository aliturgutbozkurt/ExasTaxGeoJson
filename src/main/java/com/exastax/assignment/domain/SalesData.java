package com.exastax.assignment.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "salesDatas")
// @JsonPropertyOrder({ "transactionDate", "product", "price", "paymentType",
// "name", "city", "state", "country",
// "accountCreated", "lastLogin", "latitude", "longutude" })
public class SalesData {

	public SalesData() {
	}

	@Id
	private String id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yy HH:mm")
	@JsonAlias(value = "Transaction_date")
	private Date transactionDate;

	@JsonAlias(value = "Product")
	private String product;

	@JsonAlias(value = "Price")
	private BigDecimal price;

	@JsonAlias(value = "Payment_Type")
	private String paymentType;

	@JsonAlias(value = "Name")
	private String name;

	@JsonAlias(value = "City")
	private String city;

	@JsonAlias(value = "State")
	private String state;

	@JsonAlias(value = "Country")
	private String country;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yy HH:mm")
	@JsonAlias(value = "Account_Created")
	private Date accountCreated;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yy HH:mm")
	@JsonAlias(value = "Last_Login")
	private Date lastLogin;

	@JsonAlias(value = "Latitude")
	@JsonFormat(shape = JsonFormat.Shape.NUMBER)
	private BigDecimal latitude;

	@JsonAlias(value = "Longitude")
	@JsonFormat(shape = JsonFormat.Shape.NUMBER)
	private BigDecimal longitude;

	@GeoSpatialIndexed(useGeneratedName = true, type = GeoSpatialIndexType.GEO_2DSPHERE)
	@JsonAlias(value = "Location")
	private GeoJsonPoint location;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getAccountCreated() {
		return accountCreated;
	}

	public void setAccountCreated(Date accountCreated) {
		this.accountCreated = accountCreated;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public GeoJsonPoint getLocation() {
		return location;
	}

	public void setLocation(GeoJsonPoint location) {
		this.location = location;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "\nSalesData [id=" + id + ", transactionDate=" + transactionDate + ", product=" + product + ", price="
				+ price + ", paymentType=" + paymentType + ", name=" + name + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", accountCreated=" + accountCreated + ", lastLogin=" + lastLogin
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", location=" + location + "] ";
	}
}
