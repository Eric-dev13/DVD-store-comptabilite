import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { ClientModel } from 'src/app/services/client-model.interface';
import { ClientService } from 'src/app/services/client.service';
import { environment } from 'src/environments/environment.development';
import { faCheck } from '@fortawesome/free-solid-svg-icons';



@Component({
  selector: 'app-form-client',
  templateUrl: './form-client.component.html',
  styleUrls: ['./form-client.component.scss']
})
export class FormClientComponent implements OnInit {

  constructor(private clientService: ClientService, private router: Router, private route : ActivatedRoute){}

  PUBLIC_URL_UPLOAD = environment.PUBLIC_URL_UPLOAD;

  faCheck=faCheck;

  id: any;

  client: ClientModel = {
    id: 0,
    firstname:'',
    lastname:'',  
    address:''
  }

  selectedFile!: File;
  selectedImage: any;

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get("id");

    if (this.id != null){
      this.clientService.findById(this.id).subscribe({
        next: (data) => {
          console.table(data),
          this.client = data,
          console.table(this.client)
        },
        error: (err) => console.log('Observer got an error: ' + err),
        complete: () => console.log('Client récupèré')
      })
    }
  }

  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0];
    this.selectedImage = URL.createObjectURL(this.selectedFile); // Crée l'URL pour l'image sélectionnée
  }

  send = (form: NgForm) => {
    //console.log("form: ", form.value)
    this.id = this.route.snapshot.paramMap.get("id");

    if (this.id != null){
      // mode Update
      //console.log("Update")
      this.clientService.update(this.id, form.value).subscribe((response) => {
        this.router.navigate(["/clients"]);
        //console.log(response)
      });
    } else {
      // Mode Add
     // console.log("Add")
      this.clientService.add(form.value).subscribe((response) => {
        this.router.navigate(["/clients"]);
        //console.log(response)
      });
    }
  }

}
