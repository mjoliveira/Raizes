import Validator from '../utils/validator'

export default {
  validacaoFormRegistroCliente: () => {
    const validador = new Validator('#registraCliente');
    console.log("Validator",validador);


    validador.setRulesForEachInputs({
      rules: {
        required: true
      }
    });
  }
}