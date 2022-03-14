<template>
    <div v-if="deals">
        <deal-card class="deal-card" v-for="d in deals" :key="d.name" :propsDealSummary="d"></deal-card>
    </div>
</template>

<script>
import axios from 'axios';

import {DlabsQuery} from '@/js/DlabsQuery.js';

import DealSummary from '@/components/DealSummary.vue';

export default {
    name:"ViewDealCards",
    components:{
        DealCard: DealSummary,
    },
    data(){
        return{
            deals: {},
            dlabsQuery: new DlabsQuery(),
        }
    },
    mounted(){
        this.findAllDeals()
    },
    methods:{
        findAllDeals(){
            this.dlabsQuery.configureUrl('all')

            axios.get(this.dlabsQuery.url, this.dlabsQuery.headers).
            then(response => {
                this.deals = response.data
            }).
            catch(error => {
                console.error(error);
            });
        },
    },
}
</script>

<style scoped>

.deal-card{
    min-width: 750px;
    max-width: 750px;
    border: 1px solid lightgray;
    background: white;

    padding: 5px;
    margin: 3px;
}

</style>