import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SideNavService {
  subscription: BehaviorSubject<boolean> = new BehaviorSubject(false);

  constructor() { }

  open(){
    this.subscription.next(true);
  }

  close(){
    this.subscription.next(false);
  }

  toggle(){
    this.subscription.next(!this.subscription.value);
  }

}
