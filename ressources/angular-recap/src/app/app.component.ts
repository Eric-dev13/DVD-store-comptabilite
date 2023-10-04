import { Component } from '@angular/core';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'angular-recap';
  searchText = 'a';

  handleSearchInput = (event: any) => {
    this.searchText = event?.target.value
  }

  handleButtonSearchClick = () => {
    console.log(this.searchText)
  }
}


/*

() sur des attributs html => aller chercher la valeur dans le ts seulement pour les events
[] sur des attributs html => aller chercher la valeur dans le ts pour les variables
{} à l'interieur des balises => affiche les valeurs dans le html qui viennent du ts

([]) ce sont des attributs spéciaux pour html : ([ngModel]) => two way binding relation constante entre le ts et l'html


*/
