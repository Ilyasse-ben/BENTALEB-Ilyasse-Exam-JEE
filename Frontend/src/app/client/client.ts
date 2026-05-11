import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { ClientServ } from '../service/client-serv';
import { Router } from '@angular/router';
import { ClientDATA } from '../../model/client';

@Component({
  selector: 'app-client',
  imports: [ReactiveFormsModule],
  templateUrl: './client.html',
  styleUrl: './client.css',
})
export class Client implements OnInit {
  formgroup!: FormGroup;
  formgroupTron!: FormGroup;
  type: string = 'DEBIT';
  showMessage: boolean = false;
  data!: Array<ClientDATA>;
  errorMessage!: string;

    constructor(private clientSer: ClientServ, private fb: FormBuilder, private router: Router) {

    }

    ngOnInit(): void {
      this.formgroup = this.fb.group({
        keyword: this.fb.control("")
      });
      this.getAllData();

    }
    getAllData() {
      this.clientSer.getAllclient().subscribe({
        next: (data) => { this.data = data; },
        error: (err) => { this.errorMessage = err.message; console.log(err.message) }
      });
    }
  deleteClient(clt:ClientDATA){
    let conf=confirm("vous éte sur que vous devez surrprime ce user")
    if(conf){
      this.clientSer.deleteClient(clt.id).subscribe({
        next: (data) => { alert("le client est bien supprimer"); this.ngOnInit },
        error: (err) => { this.errorMessage = err.message; console.log(err.message) }
      });
    }
   
  }
 
    
  }
