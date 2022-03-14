import { Component, OnInit } from '@angular/core';

import { DealService } from '../deal.service';
import { Deal } from '../deal';

@Component({
  selector: 'app-deal-form',
  templateUrl: './deal-form.component.html',
  styleUrls: ['./deal-form.component.css']
})
export class DealFormComponent implements OnInit {

  submitted: boolean = false;

  model: Deal;

  constructor(private dealService: DealService) {
    this.model = {
      id: 0, title: '', shop_name: '', shop_link: '', price_old: 0, price_new: 0,
      promo_code: '', temperature: 0, creator: 'admin', date_post: '', img_url: '', description: ''
    }
  }

  ngOnInit(): void {}

  OnSubmit(){
    this.submitted = true;
    const date_now = new Date(); 
    this.model.date_post = date_now.toISOString();
    console.log(this.model);
    console.log("DealService.OnSubmit() called.");

    this.dealService.addDeal(this.model).subscribe();

    window.alert("New Deal Submitted");
  }

  reset(){
    console.log("reset form")
  }
}
