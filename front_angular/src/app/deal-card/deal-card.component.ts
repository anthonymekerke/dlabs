import { Component, OnInit, Input } from '@angular/core';

import { Deal } from '../deal';

@Component({
  selector: 'app-deal-card',
  templateUrl: './deal-card.component.html',
  styleUrls: ['./deal-card.component.css']
})
export class DealCardComponent implements OnInit {

  @Input() deal?: Deal;

  constructor() {}

  ngOnInit(): void {}

}
