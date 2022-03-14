package fr.univlittoral.dlabs.beans;

import java.util.Date;

public class SinglePageDTO {

    private Integer id;

    private String title;

    private String shop_link;

    private String shop_name;

    private Float price_old;

    private Float price_new;

    private String promo_code;

    private Integer temperature;

    private String creator;

    private Date date_post;

    private String img_url;

    private String description;

    public SinglePageDTO(Integer id, String title, String shop_link, String shop_name, Float price_old, Float price_new, String promo_code, Integer temperature, String creator, Date date_post, String img_url, String description) {
        this.id = id;
        this.title = title;
        this.shop_link = shop_link;
        this.shop_name = shop_name;
        this.price_old = price_old;
        this.price_new = price_new;
        this.promo_code = promo_code;
        this.temperature = temperature;
        this.creator = creator;
        this.date_post = date_post;
        this.img_url = img_url;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShop_link() {
        return shop_link;
    }

    public void setShop_link(String shop_link) {
        this.shop_link = shop_link;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public Float getPrice_old() {
        return price_old;
    }

    public void setPrice_old(Float price_old) {
        this.price_old = price_old;
    }

    public Float getPrice_new() {
        return price_new;
    }

    public void setPrice_new(Float price_new) {
        this.price_new = price_new;
    }

    public String getPromo_code() {
        return promo_code;
    }

    public void setPromo_code(String promo_code) {
        this.promo_code = promo_code;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getDate_post() {
        return date_post;
    }

    public void setDate_post(Date date_post) {
        this.date_post = date_post;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
