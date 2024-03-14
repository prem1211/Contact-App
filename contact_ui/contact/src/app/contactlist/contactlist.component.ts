import { Component, OnInit } from '@angular/core';
import { Contact } from '../contact';
import { ContactService } from '../contact.service';
import { Router } from '@angular/router';
import { error, log } from 'console';

@Component({
  selector: 'app-contactlist',
  templateUrl: './contactlist.component.html',
  styleUrl: './contactlist.component.css',
})
export class ContactlistComponent implements OnInit {
  contacts: Contact[] = [];

  constructor(private contactService: ContactService, private router: Router) {}

  ngOnInit(): void {
    this.getAllContacts();
  }

  getAllContacts() {
    this.contactService.getAllContacts().subscribe((data) => {
      this.contacts = data;
    });
  }

  deleteContact(id: number) {
    this.contactService.deleteContact(id).subscribe(
      (data) => {
        console.log('Succesfull.....');
        console.log(data);
        this.getAllContacts();
      },
      (error) => {
        console.log('Failed.....');
        console.log(error);
      }
    );
  }

  editContact(id: number) {
    this.router.navigate(['/edit', id]);
  }
}
