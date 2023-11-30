const { DataTypes } = require("sequelize");
const sequelize = require("../db");

const Note = sequelize.define("Note", {
  NoteID: { type: DataTypes.INTEGER, primaryKey: true, autoIncrement: true },
  NoteTitle: { type: DataTypes.STRING, defaultValue: "", allowNull: true },
  NoteData: { type: DataTypes.STRING, defaultValue: "", allowNull: true },
  NoteTime: {type: DataTypes.DATE}
});

module.exports = {
  Note,
};
