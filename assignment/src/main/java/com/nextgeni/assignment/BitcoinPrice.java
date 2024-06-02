package com.nextgeni.assignment;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class BitcoinPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Code is mandatory")
    @Size(max = 4, message = "Code can have at most 3 characters")
    private String code;

    @NotBlank(message = "Symbol is mandatory")
    @Size(max = 8, message = "Symbol can have at most 5 characters")
    private String symbol;

    @NotBlank(message = "Rate is mandatory")
    @Size(max = 20, message = "Rate can have at most 20 characters")
    private String rate;

    @NotBlank(message = "Description is mandatory")
    @Size(max = 50, message = "Description can have at most 50 characters")
    private String description;

    @NotNull(message = "Rate float is mandatory")
    private Double rateFloat;

    @NotNull(message = "Updated time is mandatory")
    private LocalDateTime updatedTime;

    
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getRateFloat() {
		return rateFloat;
	}
	public void setRateFloat(Double rateFloat) {
		this.rateFloat = rateFloat;
	}
    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

}