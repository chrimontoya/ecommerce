import {EventEmitter, Injectable} from '@angular/core';
import {BehaviorSubject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SideNavService {
  openedState: any = new EventEmitter<boolean>(false);
  currentState: boolean = false;

  constructor() {

  }
  open(): void {
    this.currentState = true;
    this.openedState.emit(true);
  }

  close(): void {
    this.currentState = false;
    this.openedState.emit(false);
  }

  toggle(): void {
    this.currentState = !this.currentState;
    this.openedState.emit(this.currentState);
  }

  openedChanged(state: boolean){
    this.currentState = state;
    this.openedState.emit(this.currentState);
  }

}
