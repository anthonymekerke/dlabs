import { Component, OnInit } from '@angular/core';

import { DealService } from '../deal.service';
import { Deal } from '../deal';

@Component({
  selector: 'app-deal-list',
  templateUrl: './deal-list.component.html',
  styleUrls: ['./deal-list.component.css']
})
export class DealListComponent implements OnInit {

  deals: Deal[] = [];

  constructor(private dealService: DealService) {}

  ngOnInit(): void {
    this.getDeals();
  }

  getDeals(): void{
    this.dealService.getDeals().subscribe(
      deals => this.deals = deals
    );
  }
}
