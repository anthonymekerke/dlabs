<template>
    <div class="deal-page" v-if="propsDealPage">
        <deal-summary class="summary" :propsDealSummary="deal"></deal-summary>

        <div class="promo bordered">
            <span> {{promo_code}} </span>
        </div>

        <div class="price bordered">
            <span> {{deal.price_old}} ≥ {{deal.price_new}} ({{discount}}% de remise)</span>
        </div>

        <div class="description bordered">
            <span> {{deal.description}} </span>
        </div>
    </div>
</template>

<script>
import DealSummary from '@/components/DealSummary.vue';

export default {
    name: "DealPage",
    components: {
        DealSummary,
    },
    props: {
        propsDealPage: Object,
    },
    data(){
        return{
            deal: this.propsDealPage,
        }
    },
    mounted(){
    },
    computed:{
        promo_code() {
            if(this.deal.promo_code){
                return "Code PROMO: " + this.deal.promo_code
            }

            return "Pas de code PROMO disponible"
        },
        discount() {
            return Math.round(100 -(this.deal.price_new / this.deal.price_old * 100))
        },
    },
    watch: {
        propsDealPage: function(newValue) {
            this.deal = newValue
        }
    }
}
</script>

<style scoped>

.deal-page {
    display: flex;
    flex-flow: column nowrap;

    min-width: 750px;
    width: 750px;
    border: 1px solid lightgray;
    padding: 10px; /* margin inside element */
}

.bordered{
    border: 1px solid lightslategrey;
    margin: 3px 0px;
}

.summary {
    flex: 2 1 auto;
}

.promo {
    flex: 1 1 auto;

    display: flex;
    align-items: center;
    justify-content: center;
}

.price {
    flex: 1 1 auto;

    display: flex;
    align-items: center;
    justify-content: center;
}

.description {
    flex: 6 1 auto;

    display: flex;
    align-items: flex-start;
}

</style>