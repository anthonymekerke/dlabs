export interface Deal{
    id: number;
    title: string;
    shop_name: string;
    shop_link: string;
    price_old: number;
    price_new: number;
    promo_code: string;
    creator: string;
    temperature: number;
    date_post: string;
    img_url: string;
    description: string;
}