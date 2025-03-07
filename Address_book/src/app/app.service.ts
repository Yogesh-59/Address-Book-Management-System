import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AddressBookService {
  private apiUrl = 'http://localhost:8080/addressbook'; // ✅ Correct URL

  constructor(private http: HttpClient) {}

  getContacts(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/all`); // ✅ Ensure correct endpoint
  }

  addContact(contact: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/add`, contact);
  }
}
