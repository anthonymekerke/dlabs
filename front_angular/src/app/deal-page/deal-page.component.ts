import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { DealService } from '../deal.service';
import { Deal } from '../deal';

@Component({
  selector: 'app-deal-page',
  templateUrl: './deal-page.component.html',
  styleUrls: ['./deal-page.component.css']
})
export class DealPageComponent implements OnInit {

  deal: Deal | undefined;

  constructor(private route: ActivatedRoute,
              private location: Location,
              private dealService: DealService) {}

  ngOnInit(): void {
    this.getDeal();
  }

  getDeal(){
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.dealService.getDeal(id).subscribe(
      deal => this.deal = deal
    );
  }

  discount(): number{
    if(this.deal && (this.deal.price_new < this.deal.price_old)){
      return (1 - (this.deal.price_new / this.deal.price_old));
    }
    else{
      return 0;
    }
  }

  goBack(): void{
    this.location.back();
  }

}
