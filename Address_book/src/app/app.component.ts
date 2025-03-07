import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root', // Correct selector for main component
  standalone: true,
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  imports: [FormsModule, CommonModule],
})
export class AppComponent {
  contact = {
    fullName: '',
    address: '',
    city: '',
    state: '',
    zip: '',
    phoneNumber: '',
  };

  contacts: any[] = []; // Store contacts in an array

  addContact() {
    if (this.contact.fullName && this.contact.phoneNumber) {
      this.contacts.push({ ...this.contact }); // Add contact to the array
      this.contact = { fullName: '', address: '', city: '', state: '', zip: '', phoneNumber: '' }; // Reset form
    } else {
      alert('Full Name and Phone Number are required!'); // Simple validation
    }
  }
}
