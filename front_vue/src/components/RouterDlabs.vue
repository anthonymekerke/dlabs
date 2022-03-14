<template>
    <div id="routerDlabs">

      <b-navbar type="dark" variant="dark">
        <b-navbar-brand>Dealabs</b-navbar-brand>

        <b-button size="sm" class="ml-auto" href="/#/post/deal/">+ Poster</b-button>
      </b-navbar>

      <router-view class="view-deal"></router-view>
    
    </div>
</template>

<script>
  import DealPage from '@/components/ViewDealPage.vue';
  import DealCards from '@/components/ViewDealCards.vue';
  import DealForm from '@/components/ViewDealForm.vue';

  import Vue from 'vue';
  import VueRouter from 'vue-router';
    
  const routes = [
    { path: '/deal/', component: DealCards },
    { path: '/deal/:id', component: DealPage },
    { path: '/post/deal', component: DealForm },
  ]
    
  const router = new VueRouter({
    routes
  })
  Vue.use(VueRouter);
    
  export default {
    name: 'RouterDlabs',
    router,
  }
</script>

<style scoped>

#routerDlabs{
  background-color: #e6e6e6;
}

.view-deal {
    display: flex;
    flex-direction: column;
    align-items: center;

    margin-top: 40px;
    margin-bottom: 40px;
}

</style>