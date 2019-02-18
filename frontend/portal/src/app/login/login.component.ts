import {OnInit, Component} from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit {


  ngOnInit() {

      setTimeout(function(){
        $("#loginLabel").removeClass("active");
        $("#passwordLabel").removeClass("active");
      }, 100);


  }

}
