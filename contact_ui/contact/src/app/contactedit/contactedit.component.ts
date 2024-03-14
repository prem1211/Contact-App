import { Component, OnInit } from '@angular/core';
import { Contact } from '../contact';
import { ContactService } from '../contact.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-contactedit',
  templateUrl: './contactedit.component.html',
  styleUrl: './contactedit.component.css',
})
export class ContacteditComponent implements OnInit {
  contact: Contact = new Contact();
  id: number = 0;

  constructor(
    private contactService: ContactService,
    private router: Router,
    private activeRouter: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.getContact();
  }

  getContact() {
    this.id = this.activeRouter.snapshot.params['id'];
    console.log('Updated ::' + this.id);
    this.contactService.findContact(this.id).subscribe(
      (data) => {
        console.log('Getting A Contact');
        console.log(data);
        this.contact = data;
      },
      (error) => {
        console.log('Something went wrong.....');
        console.log(error);
      }
    );
  }

  updateContact() {
    console.log('Updated');
    this.contactService.createContact(this.contact).subscribe(
      (data) => {
        console.log('Updating a Contact');
        console.log(data);
        this.router.navigate(['/contacts']);
      },
      (error) => {
        console.log('Something went wrong....');
        console.log(error);
      }
    );
  }
}
