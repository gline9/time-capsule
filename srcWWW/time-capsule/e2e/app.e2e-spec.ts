import { browser } from 'protractor';
import { AppPage } from './app.po';

describe('time-capsule App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('should have empty input box', () => {
    page.navigateTo();
    expect(page.getInputText()).toEqual('');
  });

  it('should display alert message', () => {
    page.navigateTo();
    const message = 'test';
    page.enterInputText(message);
    page.clickSubmitButton();
    expect(page.getAlertText()).toEqual(message);
  });
});
