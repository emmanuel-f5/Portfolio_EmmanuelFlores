import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Skills } from '../model/skills';

@Injectable({
  providedIn: 'root'
})
export class SkillsService {
  sURL = environment.URL + 'skills/';

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Skills[]> {
    return this.httpClient.get<Skills[]>(this.sURL + 'lista');
  }

  public detail(id: number): Observable<Skills> {
    return this.httpClient.get<Skills>(this.sURL + `detail/${id}`);
  }

  public save(skills: Skills): Observable<any> {
    return this.httpClient.post<any>(this.sURL + 'create', skills);
  }

  public update(id: number, skills: Skills): Observable<any> {
    return this.httpClient.put<any>(this.sURL + `update/${id}`, skills);
  }

  public delete(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.sURL + `delete/${id}`);
  }
}
