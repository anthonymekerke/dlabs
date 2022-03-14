<template>
    <div>
        <h1>Création d'un nouveau Deal</h1>

        <b-form @submit="onSubmit" class="deal-form">
            
            <div class="group-form">
                <label for="input-1">Titre</label>
                <input id="input-1" size="50" v-model="form.title">
            </div>

            <div class="group-form">
                <label for="input-2">Description</label>
                <textarea id="input-2" cols="50" rows="6" v-model="form.description"></textarea>
            </div>

            <div class="group-form">
                <label>Prix</label>

                <div>
                    <label for="input-3">Original</label>
                    <input id="input-3" size="10" v-model="form.price_old">
                </div>

                <div>
                    <label for="input-4">Remisé</label>
                    <input id="input-4" size="10" v-model="form.price_new">
                </div>
            </div>

            <div class="group-form">
                <label for="input-5">Enseigne</label>
                <input id="input-5" size="50" v-model="form.shop_name">
            </div>

            <div class="group-form">
                <label for="input-6">Code promo</label>
                <input id="input-6" size="50" v-model="form.promo_code">
            </div>

            <div class="group-form">
                <label for="input-7">Lien vers image</label>
                <input id="input-7" size="50" v-model="form.img_url">
            </div>

            <div class="group-form">
                <label for="input-8">Lien vers l'article</label>
                <input id="input-8" size="50" v-model="form.shop_link">
            </div>

            <div class="group-button">
                <b-button type="submit" variant="danger">Annuler</b-button>
                <b-button type="submit" variant="primary">Poster</b-button>
            </div>

        </b-form>
    </div>
</template>

<script>
import axios from 'axios';

import {DlabsQuery} from '@/js/DlabsQuery.js';

export default {
    name:"DealForm",
    data(){
        return{
            form:{
                id: 0,
                title:'',
                shop_name:'',
                shop_link:'',
                price_old: 0,
                price_new: 0,
                promo_code: '',
                temperature: 0,
                creator: '',
                date_post:'',
                img_url:'',
                description: '',
            },
            dlabsQuery: new DlabsQuery(),
        }
    },
    methods:{
        onSubmit(event) {
            event.preventDefault()
            this.form.price_old = parseFloat(this.form.price_old)
            this.form.price_new = parseFloat(this.form.price_new)
            this.form.creator = "Test_form"
            let date_now = new Date()
            this.form.date_post = date_now.toISOString(date_now)

            let data = JSON.stringify(this.form)

            this.dlabsQuery.configureUrl('add')
            axios.post(this.dlabsQuery.url, data, {
                headers:{
                    'Content-Type': 'application/json',
                    'Access-Control-Allow-Origin': ' http://localhost:8080/singlepage/',
            }}).
            then((response) => {
                console.log(response);
            }).
            catch(error => {
                console.error(error);
            });
        },
    },
}
</script>

<style scoped>

.deal-form{
    display: flex;
    flex-flow: column nowrap;
    align-items: flex-start;

    min-width: 750px;
    width: 750px;
    border: 1px solid lightgray;
    padding: 10px; /* margin inside element */
}

.group-form{
    display: flex;
    flex-flow: row nowrap;
    justify-content: space-between;

    width: 90%;
    margin: 10px 0px;
}

.group-button{
    display: flex;
    justify-content: flex-end;
    
    width: 90%;
}

label{
    font-size:larger;
    padding: 3px;
}

</style>