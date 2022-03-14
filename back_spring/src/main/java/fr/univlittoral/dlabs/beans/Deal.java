package fr.univlittoral.dlabs.beans;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "TBL_DEAL")
public class Deal {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
    private Integer id_deal;

    @Column(name="TITLE")
    private String title;

    @Column(name="SHOP_NAME")
    private String shop_name;

    @Column(name="SHOP_LINK")
    private String shop_link;

    @Column(name="PRICE_OLD")
    private Float price_old;

    @Column(name="PRICE_NEW")
    private Float price_new;

    @Column(name="PROMO_CODE")
    private String promo_code;

    @ManyToOne
    @JoinColumn(name = "fk_creator", nullable = false)
    private User creator;

    @Column(name="DATE_POST")
    private Date date_post;

    @Column(name="IMG_URL")
    private String img_url;

    @Column(name="DESCRIPTION")
    private String description;

    /*
    @OneToMany(targetEntity = Temperature.class, mappedBy = "deal")
    private Set<Temperature> temperatures;
     */

    public Integer getId_deal() {
        return id_deal;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_link() {
        return shop_link;
    }

    public void setShop_link(String shop_link) {
        this.shop_link = shop_link;
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

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
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
