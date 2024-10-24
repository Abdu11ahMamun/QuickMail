import { Component } from '@angular/core';
import { EmailService } from '../../service/email.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-email',
  templateUrl: './email.component.html',
  styleUrl: './email.component.css'
})
export class EmailComponent {
  data={
    to:"",
    subject:"",
    message:""
  }
  constructor(private email: EmailService, private snak:MatSnackBar){
    
  }
  flag= false;

  doSubmitForm(){
    if (this.data.to === '' || this.data.subject === '' || this.data.message === '') {
      this.snak.open('Fields can\'t be empty', 'OK');
      return;
    }
    this.flag= true;
    this.email.sendEmail(this.data).subscribe(
      response=>{
        console.log(response);
        this.flag=false;
        this.snak.open('Email sent successfully', 'Success');
      },
      error=>{
        console.log(error);
        this.flag=false;
        this.snak.open('Error sending email', 'Error');
      }
    )
  }

}
