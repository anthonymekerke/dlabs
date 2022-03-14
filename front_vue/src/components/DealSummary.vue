<template>
    <div class="deal-summary" v-if="deal">
        <div class="image">
            <img :src="deal.img_url">
        </div>

        <div class="recap">
            <span class="temp"> {{deal.temperature}} </span>
            <span class="title"> {{deal.title}} </span>
            <span> {{deal.creator}} | {{deal.shop_name}} </span>
        </div>

        <div class="link">
            <span> {{formatedDate}} </span>
            <b-button :href="deal.shop_link">Voir</b-button>
        </div>
    </div>
</template>

<script>
export default {
    name: "DealSummary",
    props: {
        propsDealSummary: Object,
    },
    data(){
        return{
            deal: this.propsDealSummary,
        }
    },
    computed:{
        formatedDate(){
            let parsedDate = Date.parse(this.deal.date_post)
            let dateObj = new Date(parsedDate)

            let yyyy = dateObj.getFullYear()
            let mm = dateObj.getMonth() + 1
            let dd = dateObj.getUTCDate()

            return "Ajouté le " + dd + "/" + mm + "/" + yyyy
        }
    },
    mounted(){
    },
    watch: {
        propsDealSummary: function(newValue) {
            this.deal = newValue
        }
    }
}
</script>

<style scoped>

.deal-summary {
    display: flex;
    flex-direction: row;
    align-items: stretch;
}

.image {
    flex: 1 1 auto;
}

.recap {
    flex: 3 1 auto;

    display: flex;
    flex-flow: column nowrap;
    justify-content: space-between;
}

.temp {
    font-size: 2em;
    font-weight: bold;
    color:#08ABD9;
}

.title {
    font-weight: bold;
}

.link {
    flex: 1 1 auto;

    display: flex;
    flex-flow: column nowrap;
    align-items: flex-end;
    text-align: right;
    justify-content: space-between;
}

img {
    min-width: 20px;
    min-height: 20px;

    max-width: 150px;
    max-height: 150px;
}

</style>