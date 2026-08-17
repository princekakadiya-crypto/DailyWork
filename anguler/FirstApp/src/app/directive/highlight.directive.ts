import { Directive, ElementRef, HostListener } from '@angular/core';

@Directive({
  selector: '[appHighlightDirective]',
  standalone: true,
})
export class HighlightDirective {
  constructor(private ele: ElementRef) {}

  @HostListener('click') onClick() {
    this.ele.nativeElement.style.color = 'red';
  }

  @HostListener('mouseenter') onMouseEnter() {
    this.ele.nativeElement.style.backgroundColor = 'yellow';
  }

  @HostListener('mouseout') onMouseOut() {
    this.ele.nativeElement.style.backgroundColor = '';
    this.ele.nativeElement.style.color = 'black';
  }
}
