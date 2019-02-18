import { ImobiliariaPage } from './app.po';

describe('imobiliaria App', function() {
  let page: ImobiliariaPage;

  beforeEach(() => {
    page = new ImobiliariaPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
