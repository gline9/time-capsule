import { AppModule } from './app.module';
import { TestBed, async, ComponentFixture } from '@angular/core/testing';
import { AppComponent } from './app.component';
describe('AppComponent', () => {
  let fixture: ComponentFixture<AppComponent>;
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        AppModule
      ]
    }).compileComponents();
    fixture = TestBed.createComponent(AppComponent)
  }));
  it('should create the app', async(() => {
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  }));
  it(`should start with an empty message`, async(() => {
    fixture.detectChanges();
    const app = fixture.debugElement.componentInstance;
    expect(app.message).toEqual('');
  }));
  it('should allow input', async(() => {
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    const app = fixture.debugElement.componentInstance;
    const message = 'test';
    app.message = message;
    fixture.detectChanges();
    fixture.whenRenderingDone().then(
      () =>
      {
        expect(compiled.querySelector('input').value).toContain(message);
      }
    );
  }));
  it('should clean input on submition', async(() => {
    const app: AppComponent = fixture.debugElement.componentInstance;
    const message = 'test';
    app.message = message;
    app.sendAlert();
    expect(app.message).toEqual('');
  }));
});
