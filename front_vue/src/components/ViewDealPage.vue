<template>
    <div v-if="deal">
        <deal-page :propsDealPage="deal"></deal-page>
    </div>
</template>

<script>
import axios from 'axios';

import {DlabsQuery} from '@/js/DlabsQuery.js';

import DealPage from '@/components/DealPage.vue';

export default {
    name:"ViewDealPage",
    components:{
        DealPage,
    },
    data(){
        return{
            deal: {},
            param: this.$route.params.id,
            dlabsQuery: new DlabsQuery(),
        }
    },
    mounted(){
        this.findDealById()
    },
    methods:{
        findDealById(){
            this.dlabsQuery.configureUrl(this.param)

            axios.get(this.dlabsQuery.url, this.dlabsQuery.headers).
            then(response => {
                this.deal = response.data
            }).
            catch(error => {
                console.error(error);
            });
        },
    },
    watch: {
        '$route' (to, from){
            console.log(from)
            this.param = to.params.id
            this.findDealById()
        }
    },
}
</script>

<style scoped>

</style>