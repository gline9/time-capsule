import { browser, by, element, Key } from 'protractor';

export class AppPage {
  navigateTo() {
    return browser.get('/');
  }

  getInputElement() {
    return element(by.css('app-root input'));
  }

  getInputText() {
    return this.getInputElement().getText();
  }

  enterInputText(text: string) {
    return this.getInputElement().sendKeys(text);
  }

  clickSubmitButton() {
    element(by.css('app-root button')).sendKeys(Key.ENTER);
  }

  getAlertText() {
    return browser.switchTo().alert().getText();
  }
}
